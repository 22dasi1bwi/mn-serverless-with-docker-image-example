# Based on https://gallery.ecr.aws/lambda/java
FROM public.ecr.aws/lambda/java:11

# Copy function code and runtime dependencies from Gradle layout
COPY build/classes/kotlin/main /var/task
COPY build/dependency/* /var/task/lib/
# Set the CMD to your handler (could also be done as a parameter override outside of the Dockerfile)
CMD ["example.micronaut.BookRequestHandler"]
