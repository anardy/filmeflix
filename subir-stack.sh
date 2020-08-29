echo "Gerando pacote do Filmeflix"

# Compila e gera o pacote da app
./mvnw clean package

echo "Criando a imagem docker do Filmeflix"

# Criar Imagem
docker build -t anardy/filmeflix .

sleep 10

echo "Subindo a stack do Filmeflix"

# Subir a stack
docker-compose up -d

echo "Aguardando a inicializacao da Stack"

sleep 60

echo "Validando a App"

# Valida App
status=$(curl -s -o /dev/null -w "%{http_code}" http://localhost:8080/actuator/health)
echo $status
if [ "$status" != "200" ];
then
	echo "Houve uma falha na validacao da app";
else
	echo "App validada com sucesso";
fi

echo "Processo finalizado"