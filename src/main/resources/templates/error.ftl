<#import "/spring.ftl" as spring/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimal-ui, user-scalable=no"/>
    <title><@spring.message "error.title"/></title>

    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/auth.css"/>
</head>

<body>
<div class="error container">

    <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2">
        <div class="error--header">
            <img alt="synyx Logo" src="images/logo.png">
            <h2><@spring.message "error.general"/></h2>
        </div>
        <div class="error--body">
            <p>
            <@spring.message "error.general.messageA"/>
            </p>
            <p>
            <@spring.message "error.general.messageB"/>
            </p>
            <p class="small">
            <@spring.message "error.general.contactA"/>
                <a href="<@spring.message "error.general.contactB.href"/>">
                <@spring.message "error.general.contactB"/>
                </a>.
            </p>
        </div>
    </div>
</div>

<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>