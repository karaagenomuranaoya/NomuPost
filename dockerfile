# ベースイメージを指定
FROM openjdk:17-jdk-slim

# 作業ディレクトリを作成
WORKDIR /app

# Mavenでビルドした成果物（JARファイル）をコンテナにコピー
COPY target/chatapp3-0.0.1-SNAPSHOT.jar app.jar

# アプリケーションが使用するポートを公開
EXPOSE 8080

# JARファイルを実行するエントリポイント
ENTRYPOINT ["java", "-jar", "app.jar"]
