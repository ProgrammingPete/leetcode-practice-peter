const fs = require('fs');
const { IgApiClient } = require('instagram-private-api');

const ig = new IgApiClient();

// Load previous run data
let previousData = {};
try {
    previousData = JSON.parse(fs.readFileSync('previous_data.json', 'utf8'));
} catch (error) {
    console.log('No previous data found.');
}

(async () => {
    // Log in to Instagram
    ig.state.generateDevice('your_username');
    await ig.account.login('your_username', 'your_password');

    // Fetch follower and following lists
    const accountId = await ig.user.getIdByUsername('target_account_username');
    const followersFeed = ig.feed.accountFollowers(accountId);
    const followingFeed = ig.feed.accountFollowing(accountId);

    const [followers, following] = await Promise.all([
        followersFeed.items(),
        followingFeed.items(),
    ]);

    // Fetch followers and followings of target account
    const targetFollowersFeed = ig.feed.accountFollowers(await ig.user.getIdByUsername('your_username'));
    const targetFollowingFeed = ig.feed.accountFollowing(await ig.user.getIdByUsername('your_username'));

    const [targetFollowers, targetFollowing] = await Promise.all([
        targetFollowersFeed.items(),
        targetFollowingFeed.items(),
    ]);

    // Compare current and previous data
    const addedFollowers = followers.filter(user => !previousData.followers.includes(user.pk));
    const removedFollowers = previousData.followers.filter(pk => !followers.map(user => user.pk).includes(pk));
    const addedFollowing = following.filter(user => !previousData.following.includes(user.pk));
    const removedFollowing = previousData.following.filter(pk => !following.map(user => user.pk).includes(pk));

    const notFollowingBack = targetFollowers.filter(user => !targetFollowing.map(user => user.pk).includes(user.pk));
    const notFollowedByBack = targetFollowing.filter(user => !targetFollowers.map(user => user.pk).includes(user.pk));

    // Save current data for future comparison
    const currentData = {
        followers: followers.map(user => user.pk),
        following: following.map(user => user.pk),
    };
    fs.writeFileSync('previous_data.json', JSON.stringify(currentData, null, 2));

    // Output the results
    console.log('Added Followers:', addedFollowers.map(user => user.username));
    console.log('Removed Followers:', removedFollowers);
    console.log('Added Following:', addedFollowing.map(user => user.username));
    console.log('Removed Following:', removedFollowing);
    console.log('Accounts not following back:', notFollowingBack.map(user => user.username));
    console.log('Accounts not followed by back:', notFollowedByBack.map(user => user.username));
})();