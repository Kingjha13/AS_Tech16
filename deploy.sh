
#!/bin/bash
SOURCE_DIR="../build"
TARGET_DIR="."

cp -r $SOURCE_DIR/* $TARGET_DIR

git add .
git commit -m "Update site files"
git push origin main
