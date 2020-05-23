class AddEmployee extends React.Component{

        render() {

            return (
                <div className="container">
                    <form name="employee">
                        <div className="form-group">
                            <label>Имя:</label>
                            <input type="text"
                                   name="login"
                                   className="form-control"
                            />
                        </div>
                        <div className="form-group">
                            <label>ID отдела:</label>
                            <input type="text"
                                   name="password"
                                   className="form-control"
                            />
                        </div>
                        <div className="form-group">
                            <label>Телефон:</label>
                            <input type="text"
                                   name="resource"
                                   className="form-control"
                            />
                        </div>
                    </form>
                </div>
            )
        }
}