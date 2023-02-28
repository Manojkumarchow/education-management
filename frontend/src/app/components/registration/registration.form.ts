export class RegistrationForm {
    constructor(
        public username: string,
        public password: string,
        public accessLevel: string,
        public securityQuestion: string,
        public securityAnswer: string
    ){}
}