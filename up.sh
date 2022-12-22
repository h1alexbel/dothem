echo provide your GitHub token
read github_token
echo provide your Todoist token
read todoist_token
export GITHUB_TOKEN=${github_token}
export TODOIST_TOKEN=${todoist_token}
gradle clean bootJar
docker compose up -d