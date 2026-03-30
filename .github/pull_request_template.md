## Summary

- Port Epic Knights to Fabric 1.21.4 with full mod loading
- Add addon API framework and sample tests
- Improve crash handling and diagnostics
- Add CI workflow with build/test/artifact

## Testing

- `./gradlew clean build` (passed in local environment)
- `./gradlew test` (new tests added)
- `./gradlew runClient` (environment VM is headless; graphics error expected in CI container)

## Checklist

- [x] Build compiles
- [x] Mod load path exists
- [x] Addon API and loader present
- [x] CI workflow added
- [x] README updated
