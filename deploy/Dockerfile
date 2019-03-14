FROM 10.10.103.59/onlineshop/tomcat:8
RUN rm -rf /usr/local/tomcat/webapps/ROOT/
RUN groupadd cims

RUN useradd -d /usr/local/cims -g cims -m cims
RUN chown cims:cims /usr/local/tomcat/bin/catalina.sh
ADD target/*.war /usr/local/tomcat/webapps
RUN su cims
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]