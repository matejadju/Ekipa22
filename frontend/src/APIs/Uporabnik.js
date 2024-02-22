import ApiV1 from "./ApiV1";
import axios from "axios";

export default class Uporabnik extends ApiV1{

    url
    constructor(props) {
        super(props);
        this.url = this.mainUrl + 'uporabnik'
    }

    addUser(userData) {
        return this.post(this.url, userData)
    }

    editUser(userData, id) {
        return this.put(this.url + '/' + id, userData)
    }

   async getUsers() {
        return await this.get(this.url)
    }
    async getUserByEmail(email) {
        const response = await axios.get(this.url + '/' + 'email' + '/' + email);
        return response.data;
    }

    async getUserByLogin(email, geslo) {
        return await this.post(this.url + '/login/' + email + '/' + geslo)
    }

    async updateProfil(telefon, id){
        return await this.put(this.url + '/' + telefon + '/' + id)
    }

}