set -e
echo 'phuc comes here'
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE DATABASE customer;
    CREATE USER new_user_name WITH ENCRYPTED PASSWORD 'new_password';
    GRANT ALL PRIVILEGES ON DATABASE "$POSTGRES_DB" TO "$POSTGRES_DB";
EOSQL