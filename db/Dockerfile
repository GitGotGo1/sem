# Use the latest MySQL image
FROM mysql

# Set the working directory
WORKDIR /tmp

# Copy all the files to the working directory of the container
COPY test_db/*.sql /tmp/

# Copy the main SQL file to docker-entrypoint-initdb.d.
COPY test_db/world.sql /docker-entrypoint-initdb.d

# Set the root password
ENV MYSQL_ROOT_PASSWORD example
