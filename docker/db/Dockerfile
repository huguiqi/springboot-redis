FROM mysql:8.0.21

MAINTAINER guiqi_hu@126.com

ENV TZ=Asia/Shanghai

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY ./otaapp.sql /docker-entrypoint-initdb.d