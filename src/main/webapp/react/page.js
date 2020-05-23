
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

function AddEmployeeButton(props) {
    return (
        <button onClick={props.onClick} className="btn btn-outline-primary mb-3 mr-2">
           Добавить сотрудника
        </button>
    )
}

class Page extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            contentType: 'DepartmentsTable',
            departmentId: null
        }
        this.departmentsButtonClick = this.departmentsButtonClick.bind(this)
        this.employeesButtonClick = this.employeesButtonClick.bind(this)
        this.addEmployeeButtonClick = this.addEmployeeButtonClick.bind(this)
        this.refreshTable = this.refreshTable.bind(this)
        this.departmentRowClick = this.departmentRowClick.bind(this)
    }

    departmentsButtonClick(e){
        this.setState({contentType: 'DepartmentsTable'})
    }
    employeesButtonClick(e){
        this.setState({contentType: 'EmployeesTable', departmentId: null})
    }
    addEmployeeButtonClick(e){
        this.setState({contentType: 'AddEmployee'})
    }

    refreshTable(type) {
        this.setState({contentType: type})
    }

    departmentRowClick(id) {
        this.setState({contentType: 'EmployeesTable', departmentId: id})
    }

    render() {
        console.log(this.state.contentType)
        let content
        if(this.state.contentType=='EmployeesTable') {
            content = <Employees departmentId={this.state.departmentId}/>
        }
        else if(this.state.contentType=='AddEmployee'){
            content = <AddEmployee refreshTable={this.refreshTable} />
        }
        else {
            content = <Departments handleRowClick={this.departmentRowClick}/>
        }
        return (
            <div className="containter">
                <DepartmentsButton onClick={this.departmentsButtonClick} />
                <EmployeesButton onClick={this.employeesButtonClick} />
                <AddEmployeeButton onClick={this.addEmployeeButtonClick} />
                {content}
            </div>
        )
    }
}

ReactDOM.render(
    <Page/>,
    document.getElementById('root')
);
