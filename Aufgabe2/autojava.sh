#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")"
javac -encoding ISO-8859-1 IncDecThreads.java
java IncDecThreads

