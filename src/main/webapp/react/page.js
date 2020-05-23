
function DepartmentsButton(props) {
    return (
        <button onClick={props.onClick} className="btn btn-outline-primary mb-3 mr-2">
           Отделы
        </button>
    )
}

function EmployeesButton(props) {
    return (
        <button onClick={props.onClick} className="btn btn-outline-primary mb-3 mr-2">
           Сотрудники
        </button>
    )
}

class Page extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            contentType: 'DepartmentsTable'
        }
        this.departmentsButtonClick = this.departmentsButtonClick.bind(this)
        this.employeesButtonClick = this.employeesButtonClick.bind(this)

    }

    departmentsButtonClick(e){
        this.setState({contentType: 'DepartmentsTable'})
    }
    employeesButtonClick(e){
        this.setState({contentType: 'EmployeesTable'})
    }

    render() {
        console.log(this.state.contentType)
        return (
            <div className="containter">
                <DepartmentsButton onClick={this.departmentsButtonClick} />
                <EmployeesButton onClick={this.employeesButtonClick} />
                <Departments />
            </div>
        )
    }
}

ReactDOM.render(
    <Page/>,
    document.getElementById('root')
);
