class AddEmployee extends React.Component{

    constructor(props){
        super(props)
    }

    formSubmitHandler = (event) => {
        event.preventDefault();

        // создать объект для формы
        var formData = new FormData(document.forms.employee);

        var object = {};
        formData.forEach((value, key) => {
            object[key] = value
        });
        var tel = object['tel']
        object['tel'] = []
        object['tel'].push(tel)

        var json = JSON.stringify(object);

        // отослать
        fetch("/employees", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: json
        })
            .then( result => {
                if(result.ok) {
                    this.props.refreshTable('EmployeesTable')
                }
                else {
                    alert("Ошибка")
                }
            })
    }


    render() {
        return (
            <div className="container">
                <form name="employee">
                    <div className="form-group">
                        <label>Имя:</label>
                        <input type="text"
                               name="name"
                               className="form-control"
                               placeholder="User"
                               required
                        />
                    </div>
                    <div className="form-group">
                        <label>ID отдела:</label>
                        <input type="text"
                               name="departmentId"
                               className="form-control"
                               placeholder="1"
                               required
                        />
                        <small class="form-text text-muted">см. спискок отделов</small>
                    </div>
                    <div className="form-group">
                        <label>Телефон:</label>
                        <input type="text"
                               name="tel"
                               className="form-control"
                               placeholder="1234567890"
                               required
                        />
                        <small class="form-text text-muted">любое число</small>
                    </div>
                    <div className="form-group">
                         <button className="btn btn-secondary" onClick={this.formSubmitHandler}>
                                Добавить
                         </button>
                    </div>
                </form>
            </div>
            )

    }
}