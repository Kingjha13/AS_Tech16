#!/bin/bash
rsync -av productionExecutable/ ./
git add .
git commit -m "Update changed files from build output"
git push

