package com.magistuarmory.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

public final class DiagnosticDumper {
    private static final String DIAGNOSTIC_FILE = "epicknights-diagnostics.txt";

    private DiagnosticDumper() {
    }

    public static void dump(String message, Throwable throwable) {
        try {
            Path runDir = Paths.get(System.getProperty("user.dir"));
            Path logsFolder = runDir.resolve("run/logs");
            Files.createDirectories(logsFolder);
            Path diagnosticPath = logsFolder.resolve(DIAGNOSTIC_FILE);

            StringBuilder content = new StringBuilder();
            content.append("[" + Instant.now() + "] ").append(message).append(System.lineSeparator());

            if (throwable != null) {
                content.append("Stacktrace: ").append(System.lineSeparator());
                for (StackTraceElement element : throwable.getStackTrace()) {
                    content.append("    at ").append(element).append(System.lineSeparator());
                }

                if (throwable.getCause() != null) {
                    content.append("Caused by: ").append(throwable.getCause()).append(System.lineSeparator());
                }
            }

            Files.write(diagnosticPath, content.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            EpicKnightsLogger.info("Wrote diagnostics to: {}", diagnosticPath.toAbsolutePath());
        } catch (IOException ex) {
            EpicKnightsLogger.error("Failed to dump diagnostics to file", ex);
        }
    }
}
