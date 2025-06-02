
#!/bin/bash

set -e

SOURCE_DIR="../composeApp/build/dist/wasmJs/productionExecutable"
TARGET_DIR="."

shopt -s extglob
rm -rf !(.git|deploy.sh)

cp -r "$SOURCE_DIR"/* "$TARGET_DIR"/

git add .
git commit -m "Update site build $(date '+%Y-%m-%d %H:%M:%S')" || echo "No changes to commit"
git push origin main
