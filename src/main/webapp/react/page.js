
function DepartmentsButton(props) {
    return (
        <button onClick={props.onClick} className="btn btn-primary mb-3">
           Отделы
        </button>
    )
}

class Page extends React.Component {
    constructor(props){
        super(props)
        this.departmentsButtonClick = this.departmentsButtonClick.bind(this)
    }

//    const departmentsButton = <button onClick={this.departmentsButtonClick}>!!!</button>

    departmentsButtonClick(e){
        this.set
    }

    render() {

        return (
            <div className="containter">
                <DepartmentsButton onClick={this.departmentsButtonClick} />
                <Departments />
            </div>
        )
    }
}

ReactDOM.render(
    <Page/>,
    document.getElementById('root')
);
