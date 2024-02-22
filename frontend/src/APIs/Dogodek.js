import ApiV1 from "./ApiV1";

export default class Dogodki extends ApiV1{

    url

    constructor(props) {
        super(props);
        this.url = this.mainUrl + 'dogodek'
    }

    async getDogodekByOdobren(){
        return await this.get(this.url + '/' + 'odobren')
    }
}