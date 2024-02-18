import json

file_path = "/Users/user/git_projects/leetcode-practice-peter/scripts/saved_searched form_getlists/graceguandu/followers_after.json"
with open(file_path, 'r') as f:
    data = json.load(f)
    count = 0
    for item in data['followers']:
        print(item)
        count = count + 1
    print(count)