import ApiV1 from "./ApiV1";

export default class Klub extends ApiV1{

    url

    constructor(props) {
        super(props);
        this.url = this.mainUrl + 'klub'
    }

    async getKlubByStatus(){
        return await this.get(this.url + '/' + 'status')
    }
}