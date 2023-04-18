import { Card } from 'primereact/card';
import "primeflex/primeflex.css";
const Prove = () => {
    return (
        <>
            <div className={"h-screen flex align-items-center justify-content-center"}>

                <Card className='w-screen m-3' title="Title" subTitle="SubTitle">
                    Content
                </Card>
            </div>
        </>
    );
}

export default Prove;