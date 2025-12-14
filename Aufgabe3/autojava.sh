#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")"
rm -f id.dat

javac UniqueId.java UniqueIdThreads.java
java UniqueIdThreads

