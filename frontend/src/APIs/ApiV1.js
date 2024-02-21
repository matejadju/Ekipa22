import axios from "axios";

export default class ApiV1 {

    main = ''

    axiosConfig = {
        headers:{
            'Access-Control-Allow-Origin' : '*',
            'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE,PATCH,OPTIONS',
            'Access-Control-Allow-Header' : '*'
        }
    }

    constructor() {
        this.mainUrl = 'http://localhost:8080/'
    }
    async get(url) {
        return await axios.get(url, this.axiosConfig)
    }

    async post(url, data) {
        return await axios.post(url, data, this.axiosConfig)
    }
    async put(url, data) {
        return await axios.put(url, data, this.axiosConfig)
    }
    async delete(url) {
        return await axios.delete(url,this.axiosConfig)
    }
}

