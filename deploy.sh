
#!/bin/bash
commit_message=${1:-"Update code"}
git add .
git commit -m "$commit_message"
git push origin main
