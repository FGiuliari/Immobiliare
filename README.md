# Immobiliare

contenuto classpath:

````XML
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
	<classpathentry excluding="user/" kind="src" path="src"/>
	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/jdk1.8.0_25">
		<attributes>
			<attribute name="owner.project.facets" value="java"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="con" path="org.eclipse.jst.server.core.container/org.eclipse.jst.server.tomcat.runtimeTarget/Apache Tomcat v7.0">
		<attributes>
			<attribute name="owner.project.facets" value="jst.web"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="con" path="org.eclipse.jst.j2ee.internal.web.container"/>
	<classpathentry kind="con" path="org.eclipse.jst.j2ee.internal.module.container"/>
	<classpathentry kind="output" path="WebContent/WEB-INF/classes"/>
</classpath>
````

_____________________________________

contenuto jaas.config
````
immobiliare{ 
	login.MyLoginModule required debug=true; 
};
````
