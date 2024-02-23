export default async function Homepage(data) {
    console.log('ALOOOOOOo')
    console.log(data)
    let data1 = data.dataPrikaz
    console.log(data1)
    return (
        <div>
            {data1.map((data) => {
                return (<li >{data.ime}</li>)
            })}
            homepage rasjiefjaslkeij
        </div>
    )
}