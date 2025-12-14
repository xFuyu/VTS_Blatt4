#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")"

javac FigurenThreads.java MeineFigur.java Figur.java Schreiber.java Leser.java MachMal.java
java FigurenThreads
