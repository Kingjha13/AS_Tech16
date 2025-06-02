
#!/bin/bash

set -e

SOURCE_DIR="../composeApp/build/dist/wasmJs/productionExecutable"
TARGET_DIR="."

shopt -s extglob
rm -rf !(.git|deploy.sh)

cp -r "$SOURCE_DIR"/* "$TARGET_DIR"/

git add -A

if git diff --cached --quiet; then
  echo "¿? No changes to commit"
else
  git commit -m "Update site build $(date '+%Y-%m-%d %H:%M:%S')"
  git push origin main
fi
