Kotlin JS Fetch Demo
====================

Ajax request with `org.w3c.fetch` api.

Run:

```
./gradlew compileKotlin2Js
cd server
npm install
node index.js
```

Then open <http://localhost:3000/>:

- GET: the code is simple
- POST: MANY things need to be noticed!
  - `headers` must have: `Content-Type: application/json`, otherwise the request body is missing silently
  - `body` must be a string, rather than an object: Use `JSON.stringify` to convert it to string, otherwise the request body is missing silently

See output of Chrome developer console and server-side express output.
