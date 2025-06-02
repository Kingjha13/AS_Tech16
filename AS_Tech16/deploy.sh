
#!/bin/bash

set -e

BUILD_DIR="../build"
TARGET_DIR="."

# Clean old build files (excluding .git and this script)
shopt -s extglob
rm -rf !(.git|deploy.sh)

# Copy fresh build output
cp -r "$BUILD_DIR"/* "$TARGET_DIR"/

# Commit and push
git add .
git commit -m "Update site build $(date '+%Y-%m-%d %H:%M:%S')" || echo "No changes to commit"
git push origin main
