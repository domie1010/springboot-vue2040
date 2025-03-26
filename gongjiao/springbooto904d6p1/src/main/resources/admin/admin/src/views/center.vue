<template>
  <div :style='{"minHeight":"calc(100vh - 200px)","padding":"20px 0 30px","margin":"0 auto","color":"#666","background":"none","width":"calc(100% - 60px)","fontSize":"16px","height":"100%"}'>
    <el-form
	  :style='{"border":"1px solid #ceddee","padding":"30px 0","boxShadow":"inset 0px 0px 0px 0px #E8EFF7,0 0px 0px 0px rgba(100,100,100,.1)","borderColor":"#eee","alignItems":"flex-start","borderRadius":"8px","flexWrap":"wrap","background":"rgba(255,255,255,.6)","borderWidth":"1px","display":"flex","fontSize":"inherit","borderStyle":"double"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      label-width="200px"
    >  
     <el-row>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}'   v-if="flag=='yonghu'"  label="用户账号" prop="yonghuzhanghao">
          <el-input v-model="ruleForm.yonghuzhanghao" readonly              placeholder="用户账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}'   v-if="flag=='yonghu'"  label="用户姓名" prop="yonghuxingming">
          <el-input v-model="ruleForm.yonghuxingming"               placeholder="用户姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' v-if="flag=='yonghu'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in yonghuxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' v-if="flag=='yonghu'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="yonghutouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}'   v-if="flag=='yonghu'"  label="电话号码" prop="dianhuahaoma">
          <el-input v-model="ruleForm.dianhuahaoma"               placeholder="电话号码" clearable></el-input>
        </el-form-item>
		<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' v-if="flag=='users'" label="用户名" prop="username">
			<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
		</el-form-item>
		<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit"}' v-if="flag=='users'" label="头像" prop="image">
		  <file-upload
		  tip="点击上传头像"
		  action="file/upload"
		  :limit="1"
		  :multiple="false"
		  :fileUrls="ruleForm.image?ruleForm.image:''"
		  @change="usersimageUploadChange"
		  ></file-upload>
		</el-form-item>
		<el-form-item :style='{"padding":"0","margin":"30px auto","alignItems":"center","textAlign":"center","background":"none","display":"flex","width":"60%","fontSize":"18px"}'>
			<el-button class="btn3" :style='{"border":"0px solid #3fcbca","cursor":"pointer","padding":"0 20px","margin":"0px 4px","color":"#fff","clipPath":"polygon(5% 0, 100% 0%, 95% 100%, 0% 100%)","outline":"none","borderRadius":"10px","background":"#64ac56","width":"auto","fontSize":"18px","lineHeight":"24px","height":"40px"}' type="primary" @click="onUpdateHandler">
				<span class="icon iconfont icon-tijiao16" :style='{"color":"inherit","margin":"0 2px","fontSize":"inherit"}'></span>
				确定
			</el-button>
		</el-form-item>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      yonghuxingbieOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.yonghuxingbieOptions = "男,女".split(',')
  },
  methods: {
    yonghutouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
	usersimageUploadChange(fileUrls) {
		this.ruleForm.image = fileUrls;
	},
    onUpdateHandler() {
      if((!this.ruleForm.yonghuzhanghao)&& 'yonghu'==this.flag){
        this.$message.error('用户账号不能为空');
        return
      }


      if((!this.ruleForm.yonghuxingming)&& 'yonghu'==this.flag){
        this.$message.error('用户姓名不能为空');
        return
      }


      if((!this.ruleForm.mima)&& 'yonghu'==this.flag){
        this.$message.error('密码不能为空');
        return
      }






        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }


      if( 'yonghu' ==this.flag && this.ruleForm.dianhuahaoma&&(!isMobile(this.ruleForm.dianhuahaoma))){
        this.$message.error(`电话号码应输入手机格式`);
        return
      }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
	  if(this.flag=='users'){
	  	this.ruleForm.image = this.ruleForm.image.replace(new RegExp(this.$base.url,"g"),"")
	  }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
				if(this.flag=='users'){
					this.$storage.set('headportrait',this.ruleForm.image)
				}
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: inherit;
	  	  background: none;
	  	  font-weight: 600;
	  	  display: inline-block;
	  	  width: 200px;
	  	  font-size: inherit;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 200px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  padding: 0 30px;
	  	  color: inherit;
	  	  font-size: 16px;
	  	  border-color: #b4b4b4;
	  	  border-radius: 4px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  clip-path: polygon(98% 0, 100% 51%, 98% 100%, 2% 100%, 0% 50%, 2% 0);
	  	  background: #eee;
	  	  width: 400px;
	  	  border-width: 0px;
	  	  border-style: solid;
	  	  height: 36px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  padding: 0 30px;
	  	  color: inherit;
	  	  font-size: 16px;
	  	  border-color: #C7D5E0;
	  	  border-radius: 4px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  clip-path: polygon(98% 0, 100% 51%, 98% 100%, 2% 100%, 0% 50%, 2% 0);
	  	  background: #eee;
	  	  width: auto;
	  	  border-width: 0px;
	  	  border-style: solid;
	  	  min-width: 350px;
	  	  height: 36px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  padding: 0 30px;
	  	  color: inherit;
	  	  font-size: 16px;
	  	  border-color: #C7D5E0;
	  	  border-radius: 4px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  clip-path: polygon(98% 0, 100% 51%, 98% 100%, 2% 100%, 0% 50%, 2% 0);
	  	  background: #eee;
	  	  width: auto;
	  	  border-width: 0 0 0px;
	  	  border-style: solid;
	  	  min-width: 250px;
	  	  height: 36px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 0px solid #C7D5E0;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  clip-path: polygon(90% 0, 100% 51%, 90% 100%, 10% 100%, 0% 50%, 10% 0);
	  	  color: #aaa;
	  	  background: #eee;
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 0px solid #C7D5E0;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  clip-path: polygon(90% 0, 100% 51%, 90% 100%, 10% 100%, 0% 50%, 10% 0);
	  	  color: #aaa;
	  	  background: #eee;
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 0px solid #C7D5E0;
	  	  border-radius: 4px;
	  	  padding: 10px 36px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  clip-path: polygon(95% 0, 100% 51%, 95% 100%, 5% 100%, 0% 50%, 5% 0);
	  	  color: inherit;
	  	  background: #eee;
	  	  width: 500px;
	  	  font-size: 16px;
	  	  height: 140px;
	  	}
	
	.add-update-preview .btn3 {
				border: 0px solid #3fcbca;
				cursor: pointer;
				padding: 0 20px;
				margin: 0px 4px;
				color: #fff;
				font-size: 18px;
				line-height: 24px;
				border-radius: 10px;
				outline: none;
				clip-path: polygon(5% 0, 100% 0%, 95% 100%, 0% 100%);
				background: #64ac56;
				width: auto;
				height: 40px;
			}
	
	.add-update-preview .btn3:hover {
				opacity: 0.8;
			}
	
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
