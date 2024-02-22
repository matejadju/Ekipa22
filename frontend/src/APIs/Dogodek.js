import ApiV1 from "./ApiV1";

export default class Dogodki extends ApiV1 {

    url

    constructor(props) {
        super(props);
        this.url = this.mainUrl + 'dogodek'
    }

    async getDogodekByOdobren() {
        return await this.get(this.url + '/' + 'odobren')
    }

    async postDogodek(dogodekData) {
        const token = localStorage.getItem('token');
        try {
            const response = await fetch(this.url + '/add', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                },
                body: JSON.stringify(dogodekData)
            });

            if (!response.ok) {
                throw new Error('Network response was not ok');
            }

            return await response.json();
        } catch (error) {
            console.error('Error adding dogodek:', error);
            throw error;
        }
    }
}

