#!/bin/sh

printf '\033[36m%s\033[m\n' 'build start.'

npm run build
cd $(cd $(dirname $0); pwd)
FROM_DIR=$(pwd)
cd ../backend/src/main/resources/
rm -rvf static
mkdir -p static
cp -rv $FROM_DIR/build/* static/

printf '\033[36m%s\033[m\n' 'frontend build complete.'
