		<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html">
<h:head>
	<title>User Login</title>
</h:head>
<h:body>
	<h:form>
		<h3>Enter your credentials to login</h3>
		<h:panelGrid columns="3">
			<h:outputLabel for="user">Username:</h:outputLabel>
			<h:inputText value="#{user.userId}" id="userId"></h:inputText>
			<br />
			<br />
			<h:outputLabel for="Id">Password:</h:outputLabel>
			<h:inputText value="#{user.password}"></h:inputText>
			<br />
			<br />
			<h:commandButton action="viewdetails" value="Submit"></h:commandButton>
		</h:panelGrid>
	</h:form>
</h:body>
</html>