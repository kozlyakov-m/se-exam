class Departments extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            data: []
        };
    }

    componentDidMount() {
        const url = 'departments'

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
            return (
                <tbody>
                <tr role="button" key={d.id} onClick={()=>{this.props.handleRowClick(d.id)}}>
                    <td>{d.id}</td>
                    <td>{d.department}</td>
                    <td>{d.tel}</td>
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
                        <th scope="col">department</th>
                        <th scope="col">tel</th>
                    </tr>
                    </thead>
                    {result}
                </table>
            </div>
        )
    }
}