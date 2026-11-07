# Nuvia Watch

Wear OS app for the Nuvia social platform. Messaging only: sign in with a code, profile, chats.

- Package: `com.nuvia.watch`
- Min SDK 30 (Wear OS 3+), Kotlin + Jetpack Compose for Wear OS (Material 3)
- Backend: Supabase (shared with the Nuvia web app)

## Building
Builds never run automatically. Go to **Actions -> Build -> Run workflow**,
then download the APK from the run's **Artifacts** section.

## Secrets (Settings -> Secrets and variables -> Actions)
| Name | Purpose |
| --- | --- |
| `SUPABASE_URL` | Supabase project URL |
| `SUPABASE_ANON_KEY` | Supabase public anon key |

Never add the `service_role` key to this repository or to the app.

## Docs
- `docs/security-todo.md` - known web/backend security issues to fix later
- 
