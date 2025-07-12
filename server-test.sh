#!/bin/bash
# Wait for the server to be up

set -e

HOST=${1:-localhost}
PORT=${2:-8080}
ROUTE=${3:-/actuator/health}

# Wait for the port to be open
for i in {1..30}; do
  if nc -z "$HOST" "$PORT"; then
    break
  fi
  echo "Waiting for $HOST:$PORT... ($i)"
  sleep 2
done

# Test the route
STATUS=$(curl -s -o /dev/null -w "%{http_code}" http://$HOST:$PORT$ROUTE)
if [ "$STATUS" = "200" ]; then
  echo "Server is up and $ROUTE returned 200 OK."
  exit 0
else
  echo "Server test failed: $ROUTE returned $STATUS."
  exit 1
fi
