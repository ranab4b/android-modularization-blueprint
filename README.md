# Android Modularization Blueprint — `monolith-baseline`

This branch is **not** the project - it exists purely as a build-time comparison
baseline. It's the exact same app (same screens, same fake in-memory data, same Hilt
wiring, same Compose Navigation graph) as the [`main`](../../tree/main) branch, but
collapsed into a single `:app` module instead of eight `core-*`/`feature-*` modules.

See `main` for the real README, architecture notes, and the `api` vs `implementation`
writeup - none of that applies here since there's only one module and no boundaries to
enforce.

## Why this branch exists

To measure whether modularization actually helps incremental build times, you need two
otherwise-identical apps to diff. This branch is that control group.

```bash
# Modularized
git checkout main
echo "// touch" >> feature/feature-home/src/main/kotlin/com/ranab4b/modularization/feature/home/HomeScreen.kt
time ./gradlew assembleDebug

# Monolith baseline
git checkout monolith-baseline
echo "// touch" >> app/src/main/kotlin/com/ranab4b/modularization/feature/home/HomeScreen.kt
time ./gradlew assembleDebug
```

Incremental build time after touching one file and running `./gradlew assembleDebug`:

- Monolith (this branch): [MEASURE AFTER BUILD] s
- Modularized (`main`): [MEASURE AFTER BUILD] s ([MEASURE AFTER BUILD]% faster)

## Run it

```bash
./gradlew assembleDebug
```
