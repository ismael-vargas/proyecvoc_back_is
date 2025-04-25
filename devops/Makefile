build-image:
	@ docker build -f Dockerfile -t proyectoisma:1 .

deploy:
	@ docker stack deploy --with-registry-auth -c stacksubdominio.yml proyectoisma

rm:
	@ docker stack rm proyectoisma
