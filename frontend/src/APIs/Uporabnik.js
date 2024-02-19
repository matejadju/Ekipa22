import ApiV1 from "./ApiV1";

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
    getUserById(id) {
        return this.get(this.url + '/' + id)
    }
}