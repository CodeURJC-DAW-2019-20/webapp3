cd ../SPA-app

# Build angular app
docker run --rm --name angular-cli -v "%cd%":/angular -w /angular node /bin/bash -c "npm install; npm run ng build --prod --baseHref=https://localhost:8080/new/"

cd ../docker

.\create_image.bat

