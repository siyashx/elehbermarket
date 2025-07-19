FROM openjdk:17-jdk

# HTTPS için .p12 dosyasını container içine kopyala
COPY keystore.p12 /etc/ssl/private/keystore.p12

# JAR dosyasını ekle
ADD target/elehbermarket-0.0.1-SNAPSHOT.jar elehbermarket.jar

# HTTPS portu aç
EXPOSE 8090

# Sağlık kontrolü (HTTPS!)
HEALTHCHECK --interval=30s --timeout=10s --retries=3 \
  CMD curl --fail --insecure https://localhost:8090/ || exit 1

# Uygulamayı başlat
ENTRYPOINT ["java", "-jar", "elehbermarket.jar"]
