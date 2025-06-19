# 🧱 ビルドステージ
FROM gradle:8.4-jdk17 AS builder

WORKDIR /app

# Gradle定義ファイルを先にコピー（パス修正済）
COPY app/build.gradle.kts app/settings.gradle.kts ./
COPY app/gradle ./gradle
COPY app/gradle.properties ./
COPY app/gradlew ./
COPY app/gradlew.bat ./

# 依存解決
RUN ./gradlew dependencies --no-daemon

#
COPY app/ ./

# 実行ファイルをビルド
RUN ./gradlew installDist --no-daemon


# 🚀 実行ステージ
FROM openjdk:17-slim

WORKDIR /app

COPY --from=builder /app/build/install/ktor-practice/ .

EXPOSE 8080

CMD ["bin/ktor-practice"]
