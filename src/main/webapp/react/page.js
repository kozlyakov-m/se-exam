class Page extends React.Component {



    render() {

        return (
            <div>
                <Departments/>
            </div>
        )
    }
}

ReactDOM.render(
    <Page/>,
    document.getElementById('root')
);
