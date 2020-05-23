class Employees extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            data: []
        };
    }

    componentDidMount() {
        const url = 'employees'

        fetch(url)
            .then(result => result.json())
            .then(result => {
                this.setState({
                    data: result
                })
            })
    }
    componentDidUpdate() {
        const url = 'employees'

        fetch(url)
            .then(result => result.json())
            .then(result => {
                this.setState({
                    data: result
                })
        })
    }

    render() {
        const {data} = this.state

        const result = data.map(d => {
            let numbers = d.tel.map((number) =>
                <span>{number}<br/></span>
            )
            return (
                <tbody>
                <tr role="button" key={d.id}>
                    <td>{d.id}</td>
                    <td>{d.name}</td>
                    <td>
                    {numbers}
                    </td>

                </tr>
                </tbody>
            )
        })

        return (
            <div>
                <table className="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">name</th>
                        <th scope="col">tel</th>
                    </tr>
                    </thead>
                    {result}
                </table>
            </div>
        )
    }
}