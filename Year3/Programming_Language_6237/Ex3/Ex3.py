def validate_mail(email: str) -> bool:
    return (email[0] not in '.@' and
            not email.startswith('www.') and
            '@' in email and
            email.rfind('.') > email.rfind('@') and
            len(email.split('.')[-1]) >= 2)

def test_validate_email():
    email_list = [
        "avc@abc.com",
        "www.abc@abc.com",
        "@abc.abc.com",
        ".abc@abc.com",
        "abc@abc.c"
    ]

    for email in email_list:
        result = "valid email" if validate_mail(email) else "not valid email"
        print(f"{email} is a {result}")

test_validate_email()