# Requirements

- Java 21
- Maven project
- Test framework: JUnit Jupiter
- Variant: 5 — event counter
- Shared resource: `SharedCounter`
- Unsafe implementation: `UnsafeSharedCounter`
- Safe implementation: `SafeSharedCounter`
- Thread task: `CounterTask`
- 4 threads
- 100000 iterations per thread
- `start()` for running threads
- `join()` for waiting thread completion
- `synchronized` for safe counter operations
- Time measurement with `System.nanoTime()`
- Unit tests for deterministic logic