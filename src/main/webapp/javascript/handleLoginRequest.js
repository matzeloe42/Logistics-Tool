function handleLoginRequest(args, dialog)
{
    if(args.validationFailed || !args.loggedIn)
    {
        PF(dialog).jq.effect("shake", {times:5}, 100);
    }
    else
    {
        PF(dialog).hide();
        $('#loginLink').fadeOut();
    }
}


